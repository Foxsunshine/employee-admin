<script setup>
import { useCounterStore } from "@/stores/counter";
import RegisterButton from "../components/RegisterButton.vue";
import CancelButton from "../components/CancelButton.vue";
import TheNavigationForUpdateConfirm from "@/components/TheNavigationForUpdateConfirm.vue";

const counter = useCounterStore();
</script>
<template>
  <TheNavigationForUpdateConfirm />
  <div>
    <form class="row g-3">
      <div class="msgContainer">
        <div class="mb-3">
          <p class="label-title">id</p>
          <p class="confirm-msg">{{ counter.updateId }}</p>
        </div>
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
      <p class="subTitle">上記の情報に編集します。よろしいですか？</p>
      <div class="d-grid gap-2 d-md-flex justify-content-md-center">
        <RegisterButton />
        <CancelButton />
      </div>
    </div>
  </div>
</template>
<style scoped></style>
