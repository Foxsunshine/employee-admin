<script setup>
import { ref, onMounted, computed } from "vue";
import { useCounterStore } from "@/stores/counter";

const datas = ref({});
const isLoading = ref(true);
const counter = useCounterStore();

let prevButton = ref(null);
let nextButton = ref(null);
let lastButton = ref(null);

onMounted(() => {
  prevButton = ref(document.querySelector("#prevButton"));
  nextButton = ref(document.querySelector("#nextButton"));
  lastButton = ref(document.querySelector("#lastButton"));
});
onMounted(async () => {
  datas.value = await counter.loadData();
  isLoading.value = false;
});

////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
// Pagination feature that should be refatoring
// 最適化されるべきページング機能

const currentPage = ref(1);
const itemsPerPage = ref(10);
// Maximum number of visible pages
// 表示可能なページの最大数
const maxVisibleButtons = ref(3);

// Which ten elements are displayed
// 表示されている10個の要素
const displayedData = computed(() => {
  const start = (currentPage.value - 1) * itemsPerPage.value;
  const end = start + itemsPerPage.value;
  return datas.value.slice(start, end);
});

// page　movingmennt
// ページ遷移
const nextPage = () => {
  if (currentPage.value * itemsPerPage.value < datas.value.length) {
    currentPage.value++;
    nextButton.value.blur();
  }
};
const previousPage = () => {
  if (currentPage.value > 1) {
    currentPage.value--;
    prevButton.value.blur();
  }
};
const lastPage = () => {
  currentPage.value = totalPages.value;
  lastButton.value.blur();
};

// Calculate the total number of pages
// ページの合計数を計算する
const totalPages = computed(() => {
  return Math.ceil(datas.value.length / itemsPerPage.value);
});

// the first page that is showed
// 表示されている最小ページの数字を計算する
const startPage = computed(() => {
  let start = currentPage.value - Math.floor(maxVisibleButtons.value / 2);
  return Math.max(start, 1);
});

// To count all the pages that should be shown
// 表示すべき全ページを数える
// When the page numbers is less than 3
// ページ数が3未満の場合
// Show all the page.. and do not show the "..."
// 全てのページを表示し、「...」は表示しない
// When the page numbers is more than 3
// ページ数が3以上の場合
// Show the maxVisibleButtons(3) and show the "..." if needed
// 必要に応じてmaxVisibleButtons(3)を表示し、「...」を表示する
const pages = computed(() => {
  const range = [];
  for (
    let i = startPage.value;
    i <=
    Math.min(
      startPage.value + maxVisibleButtons.value - 1,
      totalPages.value - 1
    );
    i++
  ) {
    range.push({ name: i, isDisabled: i === currentPage.value });
  }
  return range;
});

// pagination end
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////

// Set the data in the stores to the confirmation deletion page
// 確認削除ページにストア内のデータを設定する
function setDeleteData(id, name, email) {
  counter.setDeleteId(id);
  counter.setNewData(name, email);
}
// Set the data to be updated
// 更新するデータを設定する
function setUpdateData(id, name, email) {
  counter.setUpdateId(id);
  counter.setNewData(name, email);
  counter.setConfirmToUpdate();
}
</script>

<template>
  <div class="content">
    <div v-if="isLoading">Loading...</div>
    <table v-else id="myTable" class="table table-hover">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">アイコン</th>
          <th scope="col">名前</th>
          <th scope="col">メールアドレス</th>
          <th scope="col">削除</th>
          <th scope="col">編集</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="data in displayedData" :key="data.id">
          <td>{{ data.id }}</td>
          <td>
            <img
              :src="'http://localhost:8080/images/' + data.image"
              class="img-fluid rounded-circle"
            />
          </td>
          <td>{{ data.name }}</td>
          <td>{{ data.email }}</td>
          <td>
            <router-link
              :to="{ name: 'delete', params: { id: data.id } }"
              @click="setDeleteData(data.id, data.name, data.email)"
              ><h4>🗑️</h4></router-link
            >
          </td>
          <td>
            <router-link
              :to="{ name: 'update', params: { id: data.id } }"
              @click="setUpdateData(data.id, data.name, data.email)"
              ><h4>✏️</h4></router-link
            >
          </td>
        </tr>
      </tbody>
    </table>
    <ul class="pagination">
      <li class="page-item" :class="{ disabled: currentPage === 1 }">
        <button class="page-link" @click="previousPage" ref="prevButton">
          &laquo;
        </button>
      </li>
      <li class="page-item disabled" v-if="startPage > 1">
        <span class="page-link">...</span>
      </li>
      <li
        class="page-item"
        v-for="page in pages"
        :key="page.name"
        :class="{ active: page.name === currentPage }"
      >
        <button
          class="page-link"
          type="button"
          :disabled="page.isDisabled"
          @click="currentPage = page.name"
        >
          {{ page.name }}
        </button>
      </li>

      <li
        class="page-item disabled"
        v-if="startPage + maxVisibleButtons - 1 < totalPages - 1"
      >
        <span class="page-link">...</span>
      </li>

      <li class="page-item" :class="{ active: currentPage === totalPages }">
        <button
          class="page-link"
          type="button"
          @click="lastPage"
          ref="lastButton"
          :disabled="currentPage === totalPages"
        >
          {{ totalPages }}
        </button>
      </li>

      <li class="page-item" :class="{ disabled: currentPage === totalPages }">
        <button class="page-link" @click="nextPage" ref="nextButton">
          &raquo;
        </button>
      </li>
    </ul>
  </div>
</template>

<style scoped>
img {
  width: 40px;
  height: 40px;
}

/* Set the width of each column in the table */
/* テーブル内の各列の幅を設定 */
.table th:nth-child(1),
.table td:nth-child(1) {
  width: 10%;
}

.table th:nth-child(2),
.table td:nth-child(2) {
  width: 15%;
}

.table th:nth-child(3),
.table td:nth-child(3) {
  width: 20%;
}

.table th:nth-child(4),
.table td:nth-child(4) {
  width: 39%;
}

.table th:nth-child(5),
.table td:nth-child(5) {
  width: 10%;
}
.table th:nth-child(6),
.table td:nth-child(6) {
  width: 10%;
}

/*
 Rebuild pagination
 ページネーションを再構築
 Change the default color of bootstrap
*/

.pagination {
  position: relative;
}
.btn {
  background-color: #373737 !important;
  color: #373737 !important;
}

.btn:hover,
.btn:focus {
  background-color: #3d3d3d !important;
  color: #3d3d3d !important;
}

.page-link {
  color: #373737 !important;
}

.page-link:hover,
.page-link:focus {
  color: #3d3d3d !important;
}

.page-item.active .page-link {
  background-color: #e9e9e9 !important;
  border-color: #e9e9e9 !important;
}

.content {
  display: flex;
  margin-top: 100px;
  flex-direction: column;
  align-items: center;
  width: 800px;
}
</style>
