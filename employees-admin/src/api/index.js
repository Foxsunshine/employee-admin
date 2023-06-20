import { deletes, get, getBaseURL, post, put, upload } from "./request";

const HttpManager = {
  // 获取图片信息
  attachImageUrl: (url) => `${getBaseURL()}/${url}`,

  // 返回所有员工
  getAllEmployees: () => get(`employees`),

  getEmployees: (currentPage) => get(`employees/details?page=${currentPage}`),
  // 返回指定ID的员工
  getEmployeeById: (id) => get(`employees/${id}`),
  // 删除员工
  deleteEmployeeById: (id) => deletes(`delete/${id}`),
  // 添加员工
  setEmployee: ({ name, email, image }) =>
    post(`create`, {
      name,
      email,
      image,
    }),
  // 更新员工信息
  updateEmployeeMsg: (id, { name, email, image }) =>
    put(`update/${id}`, {
      name,
      email,
      image,
    }),
  uploadImage: (file) => upload(`upload`, file),

  // 是否登录成功
  //   getLoginStatus: ({ username, password }) =>
  //     post(`admin/login/status`, { username, password }),
};

export { HttpManager };
