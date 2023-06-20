import { defineStore } from "pinia";

export const useCounterStore = defineStore({
  id: "counter",
  state: () => ({
    // Used for storing id when updating
    // 更新時にIDを保存する
    updateId: 0,
    // Used for storing id when deleting
    // 削除時にIDを保存する
    deleteId: 0,

    // Used for creating, updating data
    // データの作成、更新に使用
    newData: {
      name: "aiful",
      email: "aiful@aiful.com",
      image: "1.jpeg",
    },

    // Used for manage the "Confirm" button should navigate to.
    // "Confirm"ボタンがナビゲートすべき場所を管理する
    confirmTo: "",
  }),

  actions: {
    // Determining where the "Confirm" button should navigate to.
    // "Confirm"ボタンがナビゲートする場所を決定する
    setConfirmToCreate() {
      this.confirmTo = "create";
    },
    setConfirmToUpdate() {
      this.confirmTo = "update";
    },

    // the current updating id
    // 現在更新中のID
    setUpdateId(id) {
      this.updateId = id;
    },
    // the current deleting id
    // 現在削除中のID
    setDeleteId(id) {
      this.deleteId = id;
    },
    // set the updating new data
    // 更新する新しいデータを設定する
    setNewData(name, email, image) {
      this.newData.name = name;
      this.newData.email = email;
      this.newData.image = image;
    },
    // set the updating new img
    // 更新する新しい画像を設定する
    setNewImage(img) {
      this.newImage = img;
    },
  },
});
