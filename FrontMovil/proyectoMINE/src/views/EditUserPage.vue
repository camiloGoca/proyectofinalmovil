<template>
    <ion-page>
      <ion-header>
        <ion-toolbar>
          <ion-title>Editar Usuario</ion-title>
        </ion-toolbar>
      </ion-header>
      <ion-content>
        <form @submit.prevent="updateUser">
          <ion-item>
            <ion-label position="floating">Nombre</ion-label>
            <ion-input v-model="usuario.nombre"></ion-input>
          </ion-item>
          <ion-item>
            <ion-label position="floating">Apellido</ion-label>
            <ion-input v-model="usuario.apellido"></ion-input>
          </ion-item>
          <ion-item>
            <ion-label position="floating">Correo</ion-label>
            <ion-input v-model="usuario.correo"></ion-input>
          </ion-item>
          <ion-item>
            <ion-label position="floating">Contraseña</ion-label>
            <ion-input type="password" v-model="usuario.password"></ion-input>
          </ion-item>
          <ion-button expand="full" type="submit">Actualizar</ion-button>
        </form>
        <ion-button expand="full" @click="goToUserList">Lista de Usuarios</ion-button>
      </ion-content>
    </ion-page>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        usuario: {
          id: '',
          nombre: '',
          apellido: '',
          correo: '',
          password: ''
        }
      };
    },
    created() {
      const user = this.$route.params.user;
      if (user) {
        this.usuario = { ...user };
      }
    },
    methods: {
      async updateUser() {
        try {
          await axios.put(`http://localhost:9000/ProyectoDemo/usuario/updateUsuario/${this.usuario.id}`, this.usuario);
          alert('Usuario actualizado exitosamente');
          this.goToUserList();
        } catch (error) {
          console.error(error);
          alert('Error al actualizar usuario');
        }
      },
      goToUserList() {
        this.$router.push('/user-list');
      }
    }
  };
  </script>
  