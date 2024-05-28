<!-- src/views/PlanDeComidas.vue -->
<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Plan de Comidas</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content class="ion-padding">
      <ion-grid>
        <!-- Nombre del plan de comida -->
        <ion-row>
          <ion-col>
            <h2>Nombre</h2>
            <ion-item>
              <ion-input v-model="nombre" placeholder="Nombre"></ion-input>
            </ion-item>
          </ion-col>
        </ion-row>
        <!-- Selección de recetas -->
        <ion-row>
          <ion-col>
            <h2>Recetas del plan de comida</h2>
            <ion-item>
              <ion-select multiple v-model="recetasSeleccionadas" placeholder="Seleccionar recetas">
                <ion-select-option v-for="receta in todasRecetas" :key="receta.id" :value="receta">
                  {{ receta.nombre }}
                </ion-select-option>
              </ion-select>
            </ion-item>
          </ion-col>
        </ion-row>
        <!-- Fechas -->
        <ion-row>
          <ion-col>
            <h2>Fecha inicio</h2>
            <ion-item>
              <ion-datetime v-model="fechaInicio" display-format="YYYY-MM-DD" placeholder="Fecha inicio"></ion-datetime>
            </ion-item>
          </ion-col>
        </ion-row>
        <ion-row>
          <ion-col>
            <h2>Fecha fin</h2>
            <ion-item>
              <ion-datetime v-model="fechaFin" display-format="YYYY-MM-DD" placeholder="Fecha fin"></ion-datetime>
            </ion-item>
          </ion-col>
        </ion-row>
      </ion-grid>
      <ion-button @click="guardarPlanDeComida" expand="full" color="success">Guardar Plan de Comida</ion-button>
      <ion-button @click="navigateTo('lista-planes')" expand="full" color="primary">Ver Lista de Planes</ion-button>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import axios from '../axios';
import { 
  IonPage, 
  IonHeader, 
  IonToolbar, 
  IonTitle, 
  IonContent, 
  IonGrid, 
  IonRow, 
  IonCol, 
  IonItem, 
  IonInput, 
  IonButton, 
  IonSelect, 
  IonSelectOption, 
  IonDatetime 
} from '@ionic/vue';

const router = useRouter();
const nombre = ref('');
const recetasSeleccionadas = ref([]);
const todasRecetas = ref([]);
const fechaInicio = ref(new Date().toISOString().split('T')[0]);
const fechaFin = ref(new Date().toISOString().split('T')[0]);

const obtenerRecetas = async () => {
  try {
    const response = await axios.get('/receta/get');
    todasRecetas.value = response.data;
  } catch (error) {
    console.error('Error al obtener las recetas:', error);
  }
};

const guardarPlanDeComida = async () => {
  const planDeComida = {
    nombre: nombre.value,
    recetas: recetasSeleccionadas.value,
    fechaInicio: fechaInicio.value,
    fechaFin: fechaFin.value
  };

  console.log('Datos enviados:', planDeComida);

  try {
    const response = await axios.post('/planDeComida/save', planDeComida, {
      headers: {
        'Content-Type': 'application/json',
      }
    });
    console.log('Plan de Comida guardado con éxito', response.data);
    router.push('/lista-planes');
  } catch (error) {
    console.error('Error al guardar el Plan de Comida:', error);
  }
};

const navigateTo = (path: string) => {
  router.push({ path: `/${path}` });
};

onMounted(() => {
  obtenerRecetas();
});
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
