<!-- src/views/ListaPlanes.vue -->
<template>
    <ion-page>
      <ion-header>
        <ion-toolbar>
          <ion-title>Lista de Planes de Comida</ion-title>
        </ion-toolbar>
      </ion-header>
      <ion-content class="ion-padding">
        <ion-grid>
          <ion-row>
            <ion-col>
              <ion-list>
                <ion-item v-for="plan in planesDeComida" :key="plan.id">
                  <ion-label>
                    <h2>{{ plan.nombre }}</h2>
                    <p>{{ plan.fechaInicio }} - {{ plan.fechaFin }}</p>
                    <p v-for="receta in plan.recetas" :key="receta.id">
                      {{ receta.nombre }}
                    </p>
                  </ion-label>
                  <ion-button color="primary" @click="editarPlan(plan)">Editar</ion-button>
                  <ion-button color="danger" @click="eliminarPlan(plan.id)">Eliminar</ion-button>
                </ion-item>
              </ion-list>
            </ion-col>
          </ion-row>
          
          <!-- Sección de edición de plan de comida -->
          <ion-row v-if="isEditSectionVisible">
            <ion-col>
              <ion-card>
                <ion-card-header>
                  <ion-card-title>Editar Plan de Comida</ion-card-title>
                </ion-card-header>
                <ion-card-content>
                  <ion-grid>
                    <ion-row>
                      <ion-col>
                        <h2>Nombre</h2>
                        <ion-item>
                          <ion-input v-model="editPlan.nombre" placeholder="Nombre"></ion-input>
                        </ion-item>
                      </ion-col>
                    </ion-row>
                    <ion-row>
                      <ion-col>
                        <h2>Recetas</h2>
                        <ion-item>
                          <ion-select multiple v-model="editPlan.recetas">
                            <ion-select-option v-for="receta in todasRecetas" :key="receta.id" :value="receta">
                              {{ receta.nombre }}
                            </ion-select-option>
                          </ion-select>
                        </ion-item>
                      </ion-col>
                    </ion-row>
                    <ion-row>
                      <ion-col>
                        <h2>Fecha Inicio</h2>
                        <ion-item>
                          <ion-datetime v-model="editPlan.fechaInicio" display-format="YYYY-MM-DD" placeholder="Fecha inicio"></ion-datetime>
                        </ion-item>
                      </ion-col>
                    </ion-row>
                    <ion-row>
                      <ion-col>
                        <h2>Fecha Fin</h2>
                        <ion-item>
                          <ion-datetime v-model="editPlan.fechaFin" display-format="YYYY-MM-DD" placeholder="Fecha fin"></ion-datetime>
                        </ion-item>
                      </ion-col>
                    </ion-row>
                  </ion-grid>
                  <ion-button expand="full" color="success" @click="guardarCambios">Guardar Cambios</ion-button>
                  <ion-button expand="full" color="medium" @click="cancelarEdicion">Cancelar</ion-button>
                </ion-card-content>
              </ion-card>
            </ion-col>
          </ion-row>
        </ion-grid>
      </ion-content>
    </ion-page>
  </template>
  
  <script setup lang="ts">
  import { ref, onMounted } from 'vue';
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
    IonList, 
    IonItem, 
    IonLabel, 
    IonButton, 
    IonCard, 
    IonCardHeader, 
    IonCardTitle, 
    IonCardContent, 
    IonInput, 
    IonSelect, 
    IonSelectOption, 
    IonDatetime 
  } from '@ionic/vue';
  
  const planesDeComida = ref([]);
  const isEditSectionVisible = ref(false);
  const editPlan = ref({});
  const todasRecetas = ref([]);
  
  const obtenerPlanesDeComida = async () => {
    try {
      const response = await axios.get('/planDeComida/get');
      planesDeComida.value = response.data;
    } catch (error) {
      console.error('Error al obtener los planes de comida:', error);
    }
  };
  
  const obtenerRecetas = async () => {
    try {
      const response = await axios.get('/receta/get');
      todasRecetas.value = response.data;
    } catch (error) {
      console.error('Error al obtener las recetas:', error);
    }
  };
  
  const editarPlan = (plan) => {
    editPlan.value = JSON.parse(JSON.stringify(plan)); // Clonar el plan para edición
    isEditSectionVisible.value = true;
  };
  
  const cancelarEdicion = () => {
    isEditSectionVisible.value = false;
    editPlan.value = {};
  };
  
  const guardarCambios = async () => {
    try {
      await axios.put(`/planDeComida/update/${editPlan.value.id}`, JSON.stringify(editPlan.value), {
        headers: {
          'Content-Type': 'application/json',
        }
      });
      obtenerPlanesDeComida();
      cancelarEdicion();
    } catch (error) {
      console.error('Error al actualizar el plan de comida:', error);
    }
  };
  
  const eliminarPlan = async (id) => {
    try {
      await axios.delete(`/planDeComida/delete/${id}`);
      obtenerPlanesDeComida();
    } catch (error) {
      console.error('Error al eliminar el plan de comida:', error);
    }
  };
  
  onMounted(() => {
    obtenerPlanesDeComida();
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
  