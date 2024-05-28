<!-- src/views/AgregarReceta.vue -->
<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Agregar Receta</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content class="ion-padding">
      <ion-grid>
        <!-- Campos de la receta -->
        <ion-row>
          <ion-col>
            <h2>Nombre de la Receta</h2>
            <ion-item>
              <ion-input v-model="nombre" placeholder="Nombre"></ion-input>
            </ion-item>
          </ion-col>
        </ion-row>
        <ion-row>
          <ion-col>
            <h2>Descripción</h2>
            <ion-item>
              <ion-input v-model="descripcion" placeholder="Descripción"></ion-input>
            </ion-item>
          </ion-col>
        </ion-row>
        <ion-row>
          <ion-col>
            <h2>Imagen</h2>
            <ion-item>
              <ion-input v-model="imagen" placeholder="URL de la Imagen"></ion-input>
            </ion-item>
          </ion-col>
        </ion-row>
        <ion-row>
          <ion-col>
            <h2>Instrucciones</h2>
            <ion-item>
              <ion-input v-model="instrucciones" placeholder="Instrucciones"></ion-input>
            </ion-item>
          </ion-col>
        </ion-row>
        <ion-row>
          <ion-col>
            <h2>Tiempo de Preparación</h2>
            <ion-item>
              <ion-input v-model="tiempoPreparacion" placeholder="Tiempo de Preparación"></ion-input>
            </ion-item>
          </ion-col>
        </ion-row>
        <ion-row>
          <ion-col>
            <h2>Dificultad</h2>
            <ion-item>
              <ion-input v-model="dificultad" placeholder="Dificultad"></ion-input>
            </ion-item>
          </ion-col>
        </ion-row>
        <ion-row>
          <ion-col>
            <h2>Categoría</h2>
            <ion-item>
              <ion-input v-model="categoria" placeholder="Categoría"></ion-input>
            </ion-item>
          </ion-col>
        </ion-row>
      </ion-grid>
      <ion-button @click="guardarReceta" expand="full" color="success">Guardar Receta</ion-button>
      <ion-button @click="navigateTo('agregar-ingredientes')" expand="full" color="primary">Agregar Ingredientes</ion-button>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import axios from '../axios';
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonGrid, IonRow, IonCol, IonItem, IonInput, IonButton } from '@ionic/vue';

const router = useRouter();

const nombre = ref('');
const descripcion = ref('');
const imagen = ref('');
const instrucciones = ref('');
const tiempoPreparacion = ref('');
const dificultad = ref('');
const categoria = ref('');

const guardarReceta = async () => {
  const receta = {
    nombre: nombre.value,
    descripcion: descripcion.value,
    imagen: imagen.value,
    instrucciones: instrucciones.value,
    tiempoPreparacion: tiempoPreparacion.value,
    dificultad: dificultad.value,
    categoria: categoria.value,
    ingredientes: [] // Inicialmente vacío
  };

  try {
    const response = await axios.post('/receta/save', receta);
    console.log('Receta guardada con éxito', response.data);
    router.push({ path: '/agregar-ingredientes', query: { recetaId: response.data.id } });
  } catch (error) {
    console.error('Error al guardar la receta:', error);
  }
};

const navigateTo = (path: string) => {
  router.push({ path: `/${path}` });
};
</script>

<style scoped>
ion-header {
  --background: #32d296;
  --color: white;
}

h2 {
  margin: 0;
  padding: 10px 0;
  color: #32d296;
}
</style>

