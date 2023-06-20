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
  <div class="content">
    <form class="row g-3">
      <div class="msgContainer">
        <div class="mb-3">
          <p class="label-title">id</p>
          <p class="confirm-msg">{{ id }}</p>
        </div>
        <div class="mb-3">
          <p class="label-title">名前</p>
          <p class="confirm-msg">{{ newData.name }}</p>
        </div>
        <div class="mb-3">
          <p class="label-title">メールアドレス</p>
          <p class="confirm-msg">{{ newData.email }}</p>
        </div>
        <div class="mb-3">
          <p class="label-title">プロフィール画像</p>
          <img :src="imgUrl" class="img-fluid rounded-circle" />
        </div>
      </div>
    </form>
    <div class="box">
      <p class="subTitle">こちらのダー田を削除します。本当によろしいですか？</p>
      <div class="d-grid gap-2 d-md-flex justify-content-md-center">
        <router-link to="/employees">
          <DeleteButton @click="HttpManager.deleteEmployeeById(id)" />
        </router-link>
        <CancelButton />
      </div>
    </div>
  </div>
</template>
<style scoped>
img {
  object-fit: cover;
  width: 100px;
  height: 100px;
}
</style>
