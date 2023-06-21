<script setup>
import { ref, computed, onMounted } from "vue";
import { useCounterStore } from "@/stores/counter";
import { useRoute } from "vue-router";
import { HttpManager } from "@/api/index";
import CancelButton from "@/components/CancelButton.vue";
import ConfirmButton from "@/components/ConfirmButton.vue";
import TheNavigationForUpdate from "@/components/TheNavigationForUpdate.vue";
const route = useRoute();
const counter = useCounterStore();

const id = ref(route.params.id);
const name = ref("");
const email = ref("");
const image = ref("");
const emailInputTouched = ref(false);

onMounted(async () => {
  HttpManager.getEmployeeById(id.value).then((result) => {
    name.value = result.name;
    email.value = result.email;
    image.value = result.image;
  });
});

const isValidEmail = computed(() => {
  if (!emailInputTouched.value) {
    return true;
  }
  const re = /\S+@\S+\.\S+/;
  return re.test(email.value);
});

const imgUrl = computed(() => {
  return image.value
    ? "http://localhost:8080/images/" + image.value
    : "http://localhost:8080/images/1.jpeg";
});

function setData() {
  counter.setUpdateId(id);
  counter.setNewData(name, email, image);
}
</script>
<template>
  <TheNavigationForUpdate />
  <div class="container">
    <form class="row g-3">
      <div class="mb-3">
        <label for="name" class="form-label">Id</label>
        <p class="form-control-plaintext confirm-msg">{{ id }}</p>
      </div>
      <div class="mb-3">
        <label for="name" class="form-label">名前</label>
        <input v-model="name" type="text" class="form-control" id="name" />
      </div>
      <div class="mb-3">
        <label for="name" class="form-label">メールアドレス</label>
        <input
          v-model="email"
          @input="emailInputTouched = true"
          type="email"
          class="form-control"
          id="name"
        />
        <p v-if="!isValidEmail" style="color: red">
          メールアドレスに使用不可な文字が含まれています
        </p>
      </div>
      <div class="mb-3">
        <p>プロフィール画像</p>
        <img :src="imgUrl" class="rounded-circle" />
      </div>
      <div class="button-container">
        <router-link to="/update_confirm" v-if="isValidEmail">
          <ConfirmButton @click="setData()" />
        </router-link>
        <ConfirmButton v-else />
        <CancelButton />
      </div>
    </form>
  </div>
</template>
<style scoped></style>
