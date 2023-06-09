<script setup>
import { useCounterStore } from "@/stores/counter";

import { defineProps } from "vue";
const props = defineProps({
  newData: Object,
  id: Int,
});

const counter = useCounterStore();
const setNewData = counter.setNewData;

function creaeteNewEmployee() {
  setNewData(props.newData.name, props.newData.email);
}
</script>

<template>
  <router-link to="/update_confirm"
    ><button
      type="button"
      class="btn btn-outline-secondary"
      @click="creaeteNewEmployee"
    >
      確認
    </button>
  </router-link>
</template>
