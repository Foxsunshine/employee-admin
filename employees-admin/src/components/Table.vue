<script setup>
import { ref, onMounted, watch } from "vue";
import Pagination from "./Pagination.vue";
import { useCounterStore } from "@/stores/counter";
import { HttpManager } from "@/api/index";

const displayedData = ref({});
const isLoading = ref(true);
const counter = useCounterStore();
const currentPage = ref(1);

const totalPages = ref(0);

onMounted(async () => {
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

const handlePageChange = (newPage) => {
  currentPage.value = newPage;
  // 这里处理页码变化
};

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
  <div class="container">
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
    <Pagination
      :total-pages="totalPages"
      :initial-page="1"
      @update:currentPage="handlePageChange"
    />
  </div>
</template>

<style scoped>
img {
  max-width: 30px;
  height: 30px;
}
</style>
