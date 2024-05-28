<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-title>Iniciar Sesión</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-card id="container">
        <ion-card-title><strong>Iniciar Sesión</strong></ion-card-title>
          <ion-card-content>
            <ion-input v-model="correo" type="email" label="Email" label-placement="floating" helper-text="Enter a valid email" error-text="Invalid email"></ion-input>
            <ion-input v-model="pass" type="password" label="Contraseña" label-placement="floating" helper-text="Enter a password"></ion-input>
            <ion-button @click="login">Iniciar Sesión</ion-button>
            <a href="/src/views/RegistrarPage.vue">Crear usuario</a>
          </ion-card-content>
      </ion-card>
    </ion-content>
  </ion-page>
</template>

<script lang="ts">
import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar, IonInput, IonButton, IonCardContent, IonCardTitle, IonCard  } from '@ionic/vue';
import { ref } from 'vue';

</script>
<script setup lang="ts">

const correo = ref('');
const pass = ref('');

const login = () => {
    const email = correo.value;
    const password = pass.value;
  
    if (email === 'afavila@corhuila.edu.co' && password === 'Admin123') {      
      window.location.href = "/admin1";
    } else {
      console.log('Credenciales inválidas');
    }
  };
</script>

<style scoped>

ion-button{
  width: 73%;
  margin: 6%;
}


#container {
  text-align: center;
  padding: 5px;
  background-color: gainsboro;
  height: 45%;
  border-radius: 15px;
  position: absolute;
  left: 15%;
  right: 15%;
  top: 45%;
  transform: translateY(-50%);
}

#container strong {
  font-size: 20px;
  line-height: 26px;
  color: black;
}

#container p {
  font-size: 16px;
  line-height: 22px;
  
  color: #8c8c8c;
  
  margin: 0;
}

#container a {
  text-decoration: none;
}
</style>