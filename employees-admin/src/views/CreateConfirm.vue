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
      <div class="mb-3">
        <p>名前</p>
        <p>{{ counter.newData.name }}</p>
      </div>
      <div class="mb-3">
        <p>Email</p>
        <p>{{ counter.newData.email }}</p>
      </div>

      <div class="mb-3">
        <p>Image</p>
        <img
          :src="'http://localhost:8080/images/' + counter.newData.image"
          class="img-fluid rounded-circle"
        />
      </div>
      <div class="d-grid gap-2 d-md-flex justify-content-md-center">
        <RegisterButton />
        <CancelButton />
      </div>
    </form>
  </div>
</template>
<style scoped>
img {
  object-fit: cover;
  width: 100px;
  height: 100px;
}
</style>
