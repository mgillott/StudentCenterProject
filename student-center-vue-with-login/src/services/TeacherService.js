import axios from 'axios';

export default {

    getAllTeachers() {
        return axios.get('/teachers');
    }
}