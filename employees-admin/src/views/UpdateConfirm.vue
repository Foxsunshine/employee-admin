<script setup>
import { useCounterStore } from "@/stores/counter";
import RegisterButton from "../components/RegisterButton.vue";
import CancelButton from "../components/CancelButton.vue";
import TheNavigationForUpdateConfirm from "@/components/TheNavigationForUpdateConfirm.vue";

const counter = useCounterStore();

console.log(counter.newData.name, counter.newData.email);
</script>
<template>
  <TheNavigationForUpdateConfirm />
  <div>
    <form class="row g-3">
      <div class="mb-3">
        <p>id</p>
        <p>{{ counter.updateId }}</p>
      </div>
      <div class="mb-3">
        <p>名前</p>
        <p>{{ counter.newData.name }}</p>
      </div>
      <div class="mb-3">
        <p>Email</p>
        <p>{{ counter.newData.email }}</p>
      </div>
      <div class="d-grid gap-2 d-md-flex justify-content-md-center">
        <RegisterButton />
        <CancelButton />
      </div>
    </form>
  </div>
</template>
<style scoped></style>
