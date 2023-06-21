<script setup>
import { useCounterStore } from "@/stores/counter";
import { HttpManager } from "@/api/index";
import RegisterButton from "@/components/RegisterButton.vue";
import CancelButton from "@/components/CancelButton.vue";
import TheNavigationForCreateConfirm from "@/components/TheNavigationForCreateConfirm.vue";

const counter = useCounterStore();
</script>
<template>
  <TheNavigationForCreateConfirm />
  <div class="container">
    <form class="row g-3">
      <div class="mb-3 sub-container">
        <p class="label-title">名前</p>
        <p class="confirm-msg">{{ counter.newData.name }}</p>
      </div>
      <div class="mb-3 sub-container">
        <p class="label-title">メールアドレス</p>

        <p class="confirm-msg">{{ counter.newData.email }}</p>
      </div>

      <div class="mb-3 sub-container">
        <p class="label-title">プロフィール画像</p>

        <img
          :src="'http://localhost:8080/images/' + counter.newData.image"
          class="rounded-circle"
        />
      </div>
    </form>

    <p class="sub-title">上記の情報で新規登録をします。よろしいですか？</p>
    <div class="button-container">
      <router-link to="/employees">
        <RegisterButton
          @click="
            HttpManager.setEmployee({
              name: counter.newData.name,
              email: counter.newData.email,
              image: counter.newData.image,
            })
          "
        />
      </router-link>
      <CancelButton />
    </div>
  </div>
</template>
<style scoped></style>
