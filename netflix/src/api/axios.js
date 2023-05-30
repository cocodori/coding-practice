import axios from "axios";

const instance = axios.create({
    baseURL: "https://api.themoviedb.org/3",
    params: {
        api_key: "5e30692389be2dc5808c0bde7d1240c2",
        language: "ko-KR",
    },
});

export default instance;