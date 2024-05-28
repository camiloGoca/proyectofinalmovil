<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Crear Usuario</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content>
      <form @submit.prevent="createUser">
        <ion-item>
          <ion-label position="floating">Nombre</ion-label>
          <ion-input v-model="usuario.nombre"></ion-input>
        </ion-item>
        <ion-item>
          <ion-label position="floating">Apellido</ion-label>
          <ion-input v-model="usuario.apellido"></ion-input>
        </ion-item>
        <ion-item>
          <ion-label position="floating">Apellido</ion-label>
          <ion-input v-model="usuario.correo"></ion-input>
        </ion-item>
        <ion-item>
          <ion-label position="floating">Contraseña</ion-label>
          <ion-input type="password" v-model="usuario.password"></ion-input>
        </ion-item>
        <ion-button expand="full" type="submit">Guardar</ion-button>
      </form>
      <ion-button expand="full" @click="goToUserList">Lista de Usuarios</ion-button>
    </ion-content>
  </ion-page>
</template>

<script>
import axios from 'axios';

axios.defaults.withCredentials = true;
axios.defaults.baseURL = 'http://localhost:9000/ProyectoDemo';

export default {
  data() {
    return {
      usuario: {
        nombre: '',
        apellido: '',
        correo: '',
        password: ''
      }
    };
  },
  methods: {
    async createUser() {
      try {
        await axios.post('/usuario/saveUsuario', this.usuario);
        alert('Usuario creado exitosamente');
      } catch (error) {
        console.error(error);
        alert('Error al crear usuario');
      }
    },
    goToUserList() {
      this.$router.push('/user-list');
    }
  }
};
</script>
