<template>
    <main>
        <h1>
            Student
        </h1>
        <student-detail v-bind:student="student" />
        <student-schedule v-bind:schedule="schedule" />
    </main>
</template>


<script>

import StudentDetail from '../components/StudentDetail.vue';
import StudentService from '../services/StudentService.js';
import StudentSchedule from '../components/StudentSchedule.vue';

export default {
    components: {
        StudentDetail,
        StudentSchedule
    },
    data(){
        return{
            student: {},
            schedule: [],
        }
    },
    methods: {
        getStudent(id){
            StudentService.getStudentById(id)
            .then((response) => {
                this.student = response.data;
            })
            .catch(error => {
            console.error(error);
        })
        },
        getStudentSchedule(id){
            StudentService.getStudentSchedule(id)
            .then((response) => {
                this.schedule = response.data;
            })
            .catch(error => {
            console.error(error);
            })
        }
    },
    
    created(){
        this.getStudent(this.$route.params.studentId);
        this.getStudentSchedule(this.$route.params.studentId);
    }
}

</script>


<style>

</style>