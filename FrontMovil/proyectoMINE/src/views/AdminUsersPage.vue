<template>
    <ion-page>
      <ion-header>
        <ion-toolbar>
          <ion-title>Lista de Usuarios</ion-title>
        </ion-toolbar>
      </ion-header>
      <ion-content>
        <ion-list>
          <ion-item v-for="user in usuarios" :key="user.id">
            <ion-label>
              <h2>{{ user.nombre }} {{ user.apellido }}</h2>
              <p>{{ user.correo }}</p>
            </ion-label>
            <ion-buttons slot="end">
              <ion-button @click="editUser(user)">Editar</ion-button>
              <ion-button color="danger" @click="deleteUser(user.id)">Eliminar</ion-button>
            </ion-buttons>
          </ion-item>
        </ion-list>
        <ion-button expand="full" @click="goToCreateUser">Crear Usuario</ion-button>
      </ion-content>
    </ion-page>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        usuarios: []
      };
    },
    methods: {
      async fetchUsuarios() {
        try {
          const response = await axios.get('http://localhost:9000/ProyectoDemo/usuario/getUsuarios');
          this.usuarios = response.data;
        } catch (error) {
          console.error(error);
          alert('Error al obtener usuarios');
        }
      },
      async deleteUser(id) {
        try {
          await axios.delete(`http://localhost:9000/ProyectoDemo/usuario/deleteUsuario/${id}`);
          this.fetchUsuarios();
        } catch (error) {
          console.error(error);
          alert('Error al eliminar usuario');
        }
      },
      editUser(user) {
        // Redirigir a la página de edición con los datos del usuario
        this.$router.push({ name: 'edit-user', params: { user } });
      },
      goToCreateUser() {
        this.$router.push('/create-user');
      }
    },
    mounted() {
      this.fetchUsuarios();
    }
  };
  </script>
  