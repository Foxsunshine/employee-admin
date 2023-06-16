<script setup>
import { ref, computed } from "vue";
import { useCounterStore } from "@/stores/counter";
import ConfirmButton from "../components/ConfirmButton.vue";
import CancelButton from "../components/CancelButton.vue";
import TheNavigationForCreate from "@/components/TheNavigationForCreate.vue";
const counter = useCounterStore();

const name = ref("");
const email = ref("");
const emailInputTouched = ref(false);

const isValidEmail = computed(() => {
  if (!emailInputTouched.value) {
    return true;
  }
  const re = /\S+@\S+\.\S+/;
  return re.test(email.value);
});

function setData() {
  counter.setNewData(name.value, email.value, counter.newData.image);
  counter.setConfirmToCreate();
}
</script>

<template>
  <TheNavigationForCreate />
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
        <label for="name" class="form-label">メールアドレス</label>
        <input
          v-model="email"
          @input="emailInputTouched = true"
          type="email"
          class="form-control"
          id="name"
          placeholder="Aiful@aiful.com"
        />
        <p v-if="!isValidEmail" style="color: red">
          メールアドレスに使用不可な文字が含まれています
        </p>
      </div>
      <div class="mb-3">
        <label for="image" class="form-label">アイコン</label>
        <input
          type="file"
          class="form-control"
          id="image"
          @change="counter.uploadFile"
        />
      </div>
      <div class="d-grid gap-2 d-md-flex justify-content-md-center">
        <ConfirmButton @click="setData()" :disabled="!isValidEmail" />
        <CancelButton />
      </div>
    </form>
  </div>
</template>
<style scoped></style>
