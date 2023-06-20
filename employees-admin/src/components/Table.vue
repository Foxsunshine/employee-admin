<script setup>
import { ref, onMounted, computed, watch } from "vue";
import { useCounterStore } from "@/stores/counter";
import { HttpManager } from "@/api/index";

const displayedData = ref({});
const isLoading = ref(true);
const counter = useCounterStore();
const currentPage = ref(1);
// const itemsPerPage = ref(10);
const totalPages = ref(0);
const maxVisibleButtons = ref(3);

let prevButton = ref(null);
let nextButton = ref(null);
let lastButton = ref(null);

onMounted(async () => {
  prevButton = ref(document.querySelector("#prevButton"));
  nextButton = ref(document.querySelector("#nextButton"));
  lastButton = ref(document.querySelector("#lastButton"));
  HttpManager.getEmployees(currentPage.value - 1).then((result) => {
    displayedData.value = result.content;
    totalPages.value = result.totalPages;
    isLoading.value = false; // loding is finished
  });
});

watch(currentPage, async () => {
  isLoading.value = true;
  HttpManager.getEmployees(currentPage.value - 1).then((result) => {
    displayedData.value = result.content;
    isLoading.value = false; // loding is finished
  });
});

const nextPage = () => {
  if (currentPage.value < totalPages.value) {
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
// const lastPage = () => {
//   currentPage.value = totalPages.value;
//   lastButton.value.blur();
// };

const surroundingPages = 1;

const startPage = computed(() => {
  let start = currentPage.value - surroundingPages;
  return Math.max(start, 2);
});

const endPage = computed(() => {
  let end = currentPage.value + surroundingPages;
  return Math.min(end, totalPages.value - 1);
});

const pages = computed(() => {
  const range = [];
  for (let i = startPage.value; i <= endPage.value; i++) {
    range.push({ name: i, isDisabled: i === currentPage.value });
  }
  return range;
});

function setDeleteData(id, name, email) {
  counter.setDeleteId(id);
  counter.setNewData(name, email);
}

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
    <div v-if="totalPages === 1">
      <button class="page-link" type="button" disabled>1</button>
    </div>
    <ul class="pagination" v-else>
      <li class="page-item" :class="{ disabled: currentPage === 1 }">
        <button class="page-link" @click="previousPage" ref="prevButton">
          &laquo;
        </button>
      </li>
      <li class="page-item" :class="{ active: currentPage === 1 }">
        <button
          class="page-link"
          type="button"
          :disabled="currentPage === 1"
          @click="currentPage = 1"
        >
          1
        </button>
      </li>

      <li class="page-item disabled" v-if="startPage > 2">
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
          :disabled="currentPage === totalPages"
          @click="currentPage = totalPages"
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
  width: 35px;
  height: 35px;
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
