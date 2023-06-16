<script setup>
import { useCounterStore } from "@/stores/counter";
import RegisterButton from "../components/RegisterButton.vue";
import CancelButton from "../components/CancelButton.vue";
import TheNavigationForCreateConfirm from "@/components/TheNavigationForCreateConfirm.vue";

const counter = useCounterStore();
</script>
<template>
  <TheNavigationForCreateConfirm />
  <div>
    <form class="row g-3">
      <div class="msgContainer">
        <div class="mb-3">
          <p class="label-title">名前</p>
          <p class="confirm-msg">{{ counter.newData.name }}</p>
        </div>
        <div class="mb-3">
          <p class="label-title">メールアドレス</p>
          <p class="confirm-msg">{{ counter.newData.email }}</p>
        </div>

        <div class="mb-3">
          <p class="label-title">プロフィール画像</p>
          <img
            :src="'http://localhost:8080/images/' + counter.newData.image"
            class="img-fluid rounded-circle"
          />
        </div>
      </div>
    </form>

    <div class="box">
      <p class="subTitle">上記の情報で新規登録をします。よろしいですか？</p>
      <div class="d-grid gap-2 button-container">
        <RegisterButton />
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
.title {
  font-size: 1.5rem;
}
</style>
