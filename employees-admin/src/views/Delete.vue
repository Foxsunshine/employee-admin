<script setup>
import { ref, onMounted, computed } from "vue";
import { HttpManager } from "@/api/index";
import { useRoute } from "vue-router";
import CancelButton from "@/components/CancelButton.vue";
import DeleteButton from "@/components/DeleteButton.vue";
import TheNavigationForDelete from "@/components/TheNavigationForDelete.vue";
const route = useRoute();

const id = ref(route.params.id);
const newData = ref({});

const imgUrl = computed(() => {
  return newData.value.image
    ? "http://localhost:8080/images/" + newData.value.image
    : "http://localhost:8080/images/1.jpeg";
});

onMounted(async () => {
  HttpManager.getEmployeeById(id.value).then((result) => {
    newData.value = result;
  });
});
</script>
<template>
  <TheNavigationForDelete />
  <div class="container">
    <form class="row">
      <div class="mb-3 sub-container">
        <p class="label-title">id</p>
        <p class="confirm-msg">{{ id }}</p>
      </div>
      <div class="mb-3 sub-container">
        <p class="label-title">名前</p>
        <p class="confirm-msg">{{ newData.name }}</p>
      </div>
      <div class="mb-3 sub-container">
        <p class="label-title">メールアドレス</p>
        <p class="confirm-msg">{{ newData.email }}</p>
      </div>
      <div class="mb-3 sub-container">
        <p class="label-title">プロフィール画像</p>
        <img :src="imgUrl" class="rounded-circle" />
      </div>
    </form>
    <div class="box">
      <p class="sub-title">
        こちらのダー田を削除します。本当によろしいですか？
      </p>
      <div class="botton-container">
        <router-link to="/employees">
          <DeleteButton @click="HttpManager.deleteEmployeeById(id)" />
        </router-link>
        <CancelButton />
      </div>
    </div>
  </div>
</template>
<style scoped></style>
