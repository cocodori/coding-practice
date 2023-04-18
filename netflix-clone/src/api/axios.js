import axios from "axios";

const instance = axios.create(
    {
        baseURL: "https://api.themoivedb.org/3",
        params: {
            api_key: "4!uyP85NXsD.RHq",
            language: "ko-KR",
        },
    }
);

export default instance;