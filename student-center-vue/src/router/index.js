import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import StudentView from '../views/StudentView.vue'
import StudentDetailView from '../views/StudentDetailView.vue'
import TeacherView from '../views/TeacherView.vue'
import Login from '../components/Login.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path:'/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/students',
      name: 'students',
      component: StudentView
    },
    {
      path: '/students/:studentId',
      name: 'studentDetail',
      component: StudentDetailView
    },
    {
      path: '/teachers',
      name: 'teachers',
      component: TeacherView
    },
    {
      path: '/login',
      name: 'login',
      component: Login,
    }
  ]
})

export default router
