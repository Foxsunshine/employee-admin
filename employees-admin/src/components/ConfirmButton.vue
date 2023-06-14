<script setup>
import { useCounterStore } from "@/stores/counter";
const props = defineProps({
  disabled: Boolean,
});
const counter = useCounterStore();
console.log(props.disabled);
</script>

<template>
  <router-link
    v-if="!props.disabled"
    :to="counter.confirmTo == 'create' ? '/create_confirm' : '/update_confirm'"
  >
    <button type="button" class="btn btn-outline-secondary">確認</button>
  </router-link>
  <div v-else>
    <button type="button" class="btn btn-outline-secondary" disabled>
      確認
    </button>
  </div>
</template>
