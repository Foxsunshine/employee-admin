<script setup>
import { ref, onMounted, computed } from "vue";
import { useCounterStore } from "@/stores/counter";

const datas = ref({});
const isLoading = ref(true);
const counter = useCounterStore();

let prevButton = ref(null);
let nextButton = ref(null);

onMounted(() => {
  prevButton = ref(document.querySelector("#prevButton"));
  nextButton = ref(document.querySelector("#nextButton"));
});
onMounted(async () => {
  datas.value = await counter.loadData();
  isLoading.value = false;
});

////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
//应该被优化的翻页功能

// 实现翻页
const currentPage = ref(1);
const itemsPerPage = ref(10);

//哪十个元素被展示
const displayedData = computed(() => {
  const start = (currentPage.value - 1) * itemsPerPage.value;
  const end = start + itemsPerPage.value;
  return datas.value.slice(start, end);
});

//到下一页
const nextPage = () => {
  if (currentPage.value * itemsPerPage.value < datas.value.length) {
    currentPage.value++;
    nextButton.value.blur();
    console.log(currentPage.value);
  }
};
const previousPage = () => {
  if (currentPage.value > 1) {
    currentPage.value--;
    prevButton.value.blur();
    console.log(currentPage.value);
  }
};
//计算总的页码数量
const totalPages = computed(() => {
  return Math.ceil(datas.value.length / itemsPerPage.value);
});
//最大可见页码数量
const maxVisibleButtons = ref(3);

const startPage = computed(() => {
  let start = currentPage.value - Math.floor(maxVisibleButtons.value / 2);
  return Math.max(start, 1);
});

const pages = computed(() => {
  const range = [];
  for (
    let i = startPage.value;
    i <=
    Math.min(startPage.value + maxVisibleButtons.value - 1, totalPages.value);
    i++
  ) {
    range.push({ name: i, isDisabled: i === currentPage.value });
  }
  return range;
});
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////

// 向确认删除页面设置stores里的数据
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
          <th scope="col">名前</th>
          <th scope="col">メールアドレス</th>
          <th scope="col">削除</th>
          <th scope="col">編集</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="data in displayedData" :key="data.id">
          <td>{{ data.id }}</td>
          <td>{{ data.name }}</td>
          <td>{{ data.email }}</td>
          <td>
            <router-link
              to="/delete"
              @click="setDeleteData(data.id, data.name, data.email)"
              ><h4>🗑️</h4></router-link
            >
          </td>
          <td>
            <router-link
              to="update"
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
        v-if="startPage + maxVisibleButtons - 1 < totalPages"
      >
        <span class="page-link">...</span>
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
.table {
  table-layout: fixed;
  word-wrap: break-word;
}

.table tr {
  min-height: 1.25em;
}
#myTable {
  width: 780px;
  height: 575px;
}

/* 调整每一列的宽度 */
.table th:nth-child(1),
.table td:nth-child(1) {
  width: 10%;
}

.table th:nth-child(2),
.table td:nth-child(2) {
  width: 30%;
}

.table th:nth-child(3),
.table td:nth-child(3) {
  width: 40%;
}

.table th:nth-child(4),
.table td:nth-child(4) {
  width: 10%;
}

.table th:nth-child(5),
.table td:nth-child(5) {
  width: 10%;
}

/* 改变所有 .btn 类的背景颜色和文本颜色 */
.btn {
  background-color: #373737 !important;
  color: #373737 !important;
}

/* 改变所有 .btn 类的 hover 和 focus 状态的背景颜色和文本颜色 */
.btn:hover,
.btn:focus {
  background-color: #3d3d3d !important;
  color: #3d3d3d !important;
}

/* 改变所有 .page-link 类的背景颜色和文本颜色 */
.page-link {
  color: #373737 !important;
}

/* 改变所有 .page-link 类的 hover 和 focus 状态的背景颜色和文本颜色 */
.page-link:hover,
.page-link:focus {
  color: #3d3d3d !important;
}

.content {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.page-item.active .page-link {
  background-color: #e9e9e9 !important; /* 使用你需要的颜色 */
  border-color: #e9e9e9 !important; /* 使用你需要的颜色 */
}
</style>
