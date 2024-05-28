import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import HomePage from '../views/HomePage.vue'
import LoginPage from '@/views/LoginPage.vue';
import Admin1Page from '@/views/Admin1Page.vue';
import AdminDosPage from '@/views/AdminDosPage.vue';
import AdminTresPage from '@/views/AdminTresPage.vue';
import AdminCuatroPage from '@/views/AdminCuatroPage.vue';
import AdminCincoPage from '@/views/AdminCincoPage.vue';
import AdminSeisPage from '@/views/AdminSeisPage.vue';
import CreateUserPage from '@/views/CreateUserPage.vue';
import AdminUsersPage from '@/views/AdminUsersPage.vue';
import EditUserPage from '@/views/EditUserPage.vue';
import PlanDeComidaListaPage from '@/views/PlanDeComidaListaPage.vue';

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/home',
    name: 'Home',
    component: HomePage
  },
  {
    path: '/login',
    name: 'Login',
    component: LoginPage
  },
  {
    path: '/admin1',
    name: 'Admin1',
    component: Admin1Page
  },
  {
    path: '/agregar-receta',
    name: 'AgregarReceta',
    component: AdminDosPage
  },
  {
    path: '/agregar-ingredientes',
    name: 'AgregarIngredientes',
    component: AdminTresPage
  },
  {
    path: '/lista-recetas',
    name: 'ListaRecetas',
    component: AdminCuatroPage
  },
  {
    path: '/admincinco',
    name: 'AdminCinco',
    component: AdminCincoPage
  },
  {
    path: '/create-user',
    name: 'CreateUser',
    component: CreateUserPage

  },
  {
    path: '/user-list',
    name: 'AdminUsers',
    component: AdminUsersPage
  },
  {
    path: '/edit-user',
    name: 'EditUser',
    component: EditUserPage
  },
  {
    path: '/lista-planes',
    name: 'ListaPlan',
    component: PlanDeComidaListaPage
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
