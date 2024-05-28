<!-- src/views/ListaRecetas.vue -->
<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Lista de Recetas</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content class="ion-padding">
      <ion-grid>
        <ion-row>
          <ion-col>
            <ion-list>
              <ion-item v-for="receta in recetas" :key="receta.id">
                <ion-label>
                  <h2>{{ receta.nombre }}</h2>
                  <p>{{ receta.descripcion }}</p>
                  <p v-for="ingrediente in receta.ingredientes" :key="ingrediente.id">
                    {{ ingrediente.nombre }} - {{ ingrediente.cantidad }} {{ ingrediente.unidadDeMedida }}
                  </p>
                </ion-label>
                <ion-button color="primary" @click="editarReceta(receta)">Editar</ion-button>
                <ion-button color="danger" @click="eliminarReceta(receta.id)">Eliminar</ion-button>
              </ion-item>
            </ion-list>
          </ion-col>
        </ion-row>
        
        <!-- Sección de edición de recetas -->
        <ion-row v-if="isEditSectionVisible">
          <ion-col>
            <ion-card>
              <ion-card-header>
                <ion-card-title>Editar Receta</ion-card-title>
              </ion-card-header>
              <ion-card-content>
                <ion-grid>
                  <ion-row>
                    <ion-col>
                      <h2>Nombre de la Receta</h2>
                      <ion-item>
                        <ion-input v-model="editReceta.nombre" placeholder="Nombre"></ion-input>
                      </ion-item>
                    </ion-col>
                  </ion-row>
                  <ion-row>
                    <ion-col>
                      <h2>Descripción</h2>
                      <ion-item>
                        <ion-input v-model="editReceta.descripcion" placeholder="Descripción"></ion-input>
                      </ion-item>
                    </ion-col>
                  </ion-row>
                  <ion-row>
                    <ion-col>
                      <h2>Instrucciones</h2>
                      <ion-item>
                        <ion-input v-model="editReceta.instrucciones" placeholder="Instrucciones"></ion-input>
                      </ion-item>
                    </ion-col>
                  </ion-row>
                  <ion-row>
                    <ion-col>
                      <h2>Tiempo de Preparación</h2>
                      <ion-item>
                        <ion-input v-model="editReceta.tiempoPreparacion" placeholder="Tiempo de Preparación"></ion-input>
                      </ion-item>
                    </ion-col>
                  </ion-row>
                  <ion-row>
                    <ion-col>
                      <h2>Dificultad</h2>
                      <ion-item>
                        <ion-input v-model="editReceta.dificultad" placeholder="Dificultad"></ion-input>
                      </ion-item>
                    </ion-col>
                  </ion-row>
                  <ion-row>
                    <ion-col>
                      <h2>Categoría</h2>
                      <ion-item>
                        <ion-input v-model="editReceta.categoria" placeholder="Categoría"></ion-input>
                      </ion-item>
                    </ion-col>
                  </ion-row>
                  <ion-row>
                    <ion-col>
                      <h2>Ingredientes</h2>
                      <ion-list>
                        <ion-item v-for="(ingrediente, index) in editReceta.ingredientes" :key="index">
                          <ion-input v-model="ingrediente.nombre" placeholder="Nombre"></ion-input>
                          <ion-input v-model="ingrediente.cantidad" placeholder="Cantidad"></ion-input>
                          <ion-input v-model="ingrediente.unidadDeMedida" placeholder="Unidad"></ion-input>
                        </ion-item>
                      </ion-list>
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

<script>
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
} from '@ionic/vue';

export default {
  name: 'ListaRecetas',
  components: {
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
  },
  setup() {
    const recetas = ref([]);
    const isEditSectionVisible = ref(false);
    const editReceta = ref({});

    const obtenerRecetas = async () => {
      try {
        const response = await axios.get('/receta/get');
        console.log('Recetas obtenidas:', response.data);
        recetas.value = response.data;
      } catch (error) {
        console.error('Error al obtener las recetas:', error);
      }
    };

    const editarReceta = (receta) => {
      editReceta.value = JSON.parse(JSON.stringify(receta)); // Clonar la receta para edición
      isEditSectionVisible.value = true;
    };

    const cancelarEdicion = () => {
      isEditSectionVisible.value = false;
      editReceta.value = {};
    };

    const guardarCambios = async () => {
      try {
        await axios.put(`/receta/update/${editReceta.value.id}`, editReceta.value);
        obtenerRecetas();
        cancelarEdicion();
      } catch (error) {
        console.error('Error al actualizar la receta:', error);
      }
    };

    const eliminarReceta = async (id) => {
      try {
        await axios.delete(`/receta/delete/${id}`);
        obtenerRecetas();
      } catch (error) {
        console.error('Error al eliminar la receta:', error);
      }
    };

    onMounted(() => {
      obtenerRecetas();
    });

    return {
      recetas,
      isEditSectionVisible,
      editReceta,
      editarReceta,
      cancelarEdicion,
      guardarCambios,
      eliminarReceta,
    };
  },
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
