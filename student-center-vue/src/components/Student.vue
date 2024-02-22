<template>
    <table>
        <thead>
            <tr>
                <th>Student First Name</th>
                <th>Student Middle Name</th>
                <th>Student Last Name</th>
                <th>Student Date of Birth</th>
                <th>Student Gender</th>
                <th>Student Enrollment Date</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="student in students" v-bind:key="student.id">
                <td>{{ student.firstName }}</td>
                <td>{{ student.middleName }}</td>
                <td>{{ student.lastName }}</td>
                <td>{{ student.dateOfBirth }}</td>
                <td>{{ student.gender }}</td>
                <td>{{ student.enrollmentDate }}</td>
            </tr>
        </tbody>
    </table>
</template>

<script>
import studentService from '../services/StudentService';

export default {
    data(){
        return {
            students: []
        };
    },
    created() {
        studentService.getAllStudents()
        .then(response => {
            this.students = response.data;
        })
        .catch(error => {
            console.error(error);
        })
    }

}
</script>

<style>

</style>