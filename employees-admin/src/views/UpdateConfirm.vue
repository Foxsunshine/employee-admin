<script setup>
import { useCounterStore } from "@/stores/counter";
import RegisterButton from "@/components/RegisterButton.vue";
import CancelButton from "@/components/CancelButton.vue";
import TheNavigationForUpdateConfirm from "@/components/TheNavigationForUpdateConfirm.vue";
import { HttpManager } from "@/api";

const counter = useCounterStore();
</script>
<template>
  <TheNavigationForUpdateConfirm />
  <div class="container">
    <form class="row">
      <div class="mb-3 sub-container">
        <p class="label-title">id</p>
        <p class="confirm-msg">{{ counter.updateId }}</p>
      </div>
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
    <div class="box">
      <p class="sub-title">上記の情報に編集します。よろしいですか？</p>
      <div class="button-container">
        <router-link to="/employees"
          ><RegisterButton
            @click="
              HttpManager.updateEmployeeMsg(counter.updateId, {
                name: counter.newData.name,
                email: counter.newData.email,
                image: counter.newData.image,
              })
            "
        /></router-link>
        <CancelButton />
      </div>
    </div>
  </div>
</template>
<style scoped></style>
