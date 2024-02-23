<template>
    <table>
        <thead>
            <tr>
                <th>Teacher First Name</th>
                <th>Teacher Last Name</th>
                <th>Teacher Gender</th>
                <th>Teacher Email Address</th>
                <th>Teacher Phone Number</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="teacher in teachers" v-bind:key="teacher.id">
                <td>{{ teacher.teacherFistName }}</td>
                <td>{{ teacher.teacherLastName }}</td>
                <td>{{ teacher.teacherGender }}</td>
                <td>{{ teacher.teacherEmail }}</td>
                <td>{{ teacher.teacherPhoneNumber }}</td>
            </tr>
        </tbody>
    </table>
</template>


<script>
import teacherService from '../services/TeacherService';

export default{
    data(){
        return{
            teachers:[]
        };
    },
    created() {
        teacherService.getAllTeachers()
        .then(response => {
            this.teachers = response.data;
        })
        .catch(error => {
            console.error(error);
        })
    }

}
</script>

<style>

</style>