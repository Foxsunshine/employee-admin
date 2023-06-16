import Home from "@/views/Home.vue";
import Employees from "@/views/Employees.vue";

import { createRouter, createWebHistory } from "vue-router";

const routes = [
  { path: "/", name: "home", component: Home },
  { path: "/employees", name: "employees", component: Employees },
  {
    path: "/create",
    name: "create",
    component: () => import("@/views/Create.vue"),
  },
  {
    path: "/create_confirm",
    name: "create_confirm",
    component: () => import("@/views/CreateConfirm.vue"),
  },
  {
    path: "/update/:id",
    name: "update",
    component: () => import("@/views/Update.vue"),
  },
  {
    path: "/update_confirm",
    name: "update_confirm",
    component: () => import("@/views/UpdateConfirm.vue"),
  },
  {
    path: "/delete/:id",
    name: "delete",
    component: () => import("@/views/Delete.vue"),
  },
  {
    path: "/:pathMatch(.*)*",
    name: "NotFound",
    component: () => import("@/views/NotFound.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
