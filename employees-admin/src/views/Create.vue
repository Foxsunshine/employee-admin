<script setup>
import { ref, computed } from "vue";
import { useCounterStore } from "@/stores/counter";
import { HttpManager } from "@/api/index";
import ConfirmButton from "@/components/ConfirmButton.vue";
import CancelButton from "@/components/CancelButton.vue";
import TheNavigationForCreate from "@/components/TheNavigationForCreate.vue";
const counter = useCounterStore();

const name = ref("");
const email = ref("");
const image = ref("");
const emailInputTouched = ref(false);

const isValidEmail = computed(() => {
  if (!emailInputTouched.value) {
    return true;
  }
  const re = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
  return re.test(email.value);
});

function handleFileChange(event) {
  let file = event.target.files[0];
  console.log(file);
  HttpManager.uploadImage(file).then((imagePath) => {
    image.value = imagePath;
  });
}
function setData() {
  counter.setNewData(name.value, email.value, image.value);
}
</script>

<template>
  <TheNavigationForCreate />
  <div class="container">
    <form class="row g-3">
      <div class="mb-3">
        <label for="name" class="form-label">名前</label>
        <input
          v-model="name"
          type="text"
          class="form-control"
          id="name"
          placeholder="愛ちゃん"
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
          placeholder="ai@aiful.com"
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
          @change="handleFileChange"
        />
      </div>
      <div class="button-container">
        <router-link to="/create_confirm" v-if="isValidEmail">
          <ConfirmButton @click="setData()" />
        </router-link>
        <ConfirmButton v-else class="disabled" />
        <CancelButton />
      </div>
    </form>
  </div>
</template>
<style scoped></style>
