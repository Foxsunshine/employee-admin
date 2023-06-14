<script setup>
import { ref, onMounted, onUnmounted } from "vue";
import { useCounterStore } from "@/stores/counter";
import { useRoute, useRouter } from "vue-router";
import CancelButton from "@/components/CancelButton.vue";
import DeleteButton from "../components/DeleteButton.vue";
// import { getItem, setItem, removeItem } from "@/stores/storage.js";

const router = useRouter();
const route = useRoute();
const counter = useCounterStore();

// onMounted(() => {
//   // 从 localStorage 中读取数据
//   const data = getItem("counterData");
//   if (data) {
//     // 从 localStorage 中恢复数据
//     counter.newData = data;
//   }
// });

// onUnmounted(() => {
//   // 当组件卸载时，将数据存储到 localStorage 中
//   setItem("counterData", counter.newData);
// });
</script>
<template>
  <div>
    <form class="row g-3">
      <div class="mb-3">
        <label for="name" class="form-label">Id</label>
        <input
          readonly
          type="text"
          class="form-control-plaintext"
          :value="counter.deleteId"
        />
      </div>
      <div class="mb-3">
        <label for="name" class="form-label">名前</label>
        <input
          readonly
          type="text"
          class="form-control-plaintext"
          :value="counter.newData.name"
        />
      </div>
      <div class="mb-3">
        <label for="name" class="form-label">Email</label>
        <input
          readonly
          type="text"
          class="form-control-plaintext"
          :value="counter.newData.email"
        />
      </div>
      <div class="d-grid gap-2 d-md-flex justify-content-md-center">
        <DeleteButton />
        <CancelButton />
      </div>
    </form>
  </div>
</template>
<style scoped></style>
