<script setup>
import { ref, computed } from "vue";
import { useCounterStore } from "@/stores/counter";
import ConfirmButton from "../components/ConfirmButton.vue";
import CancelButton from "../components/CancelButton.vue";

const counter = useCounterStore();

const name = ref("");
const email = ref("");

const isValidEmail = computed(() => {
  const re = /\S+@\S+\.\S+/;
  return re.test(email.value);
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
        <p v-if="!isValidEmail" style="color: red">
          Please enter a valid email.
        </p>
      </div>
      <div class="d-grid gap-2 d-md-flex justify-content-md-center">
        <ConfirmButton
          @click="counter.setNewData(name, email)"
          :disabled="!isValidEmail"
        />
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
