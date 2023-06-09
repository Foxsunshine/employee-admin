<script setup>
import { ref } from "vue";
import { useCounterStore } from "@/stores/counter";
import ConfirmButton from "../components/ConfirmButton.vue";
import CancelButton from "../components/CancelButton.vue";

const counter = useCounterStore();

const name = ref("");
const email = ref("");

const newData = ref({
  name: "",
  email: "",
});
</script>

<template>
  <div>
    <form class="row g-3">
      <div class="mb-3">
        <label for="name" class="form-label">名前</label>
        <input
          v-model="name"
          type="text"
          class="form-control"
          id="name"
          placeholder="愛　アイフル"
        />
      </div>
      <div class="mb-3">
        <label for="name" class="form-label">Email</label>
        <input
          v-model="email"
          type="email"
          class="form-control"
          id="name"
          placeholder="Aiful@aiful.com"
        />
      </div>
      <div class="d-grid gap-2 d-md-flex justify-content-md-center">
        <ConfirmButton :newData="{ name: name, email: email }" />
        <CancelButton />
      </div>
    </form>
  </div>
</template>
<style scoped>
label {
  text-align: start;
  justify-content: start;
}
</style>
