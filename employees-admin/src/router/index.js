import Home from "@/views/Home.vue";
import Employees from "@/views/Employees.vue";
// import Create from "@/views/Create.vue";
import CreateConfirm from "@/views/CreateConfirm.vue";
import Update from "@/views/Update.vue";
import UpdateConfirm from "@/views/UpdateConfirm.vue";
import Delete from "@/views/Delete.vue";

import { createRouter, createWebHistory } from "vue-router";

const routes = [
  { path: "/", name: "home", component: Home },
  { path: "/employees", name: "employees", component: Employees },
  {
    path: "/create",
    name: "create",
    component: () => import("@/views/Create.vue"),
  },
  { path: "/create_confirm", name: "create_confirm", component: CreateConfirm },
  { path: "/update", name: "update", component: Update },
  { path: "/update_confirm", name: "update_confirm", component: UpdateConfirm },
  { path: "/delete", name: "delete", component: Delete },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
