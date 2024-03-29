import axios from "../api/axios";
import React, { useEffect, useState } from "react";
import "./Row.css";

export default function Row({ title, fetchUrl, isLargeRow, id }) {
  const [movies, setMovies] = useState([]);
  useEffect(() => {
    fetchMovieData();
  }, [fetchUrl]);

  const fetchMovieData = async () => {
    const request = await axios.get(fetchUrl);
    setMovies(request.data.results);
  };
  return (
    <section className="row">
      <h2>{title}</h2>
      <div className="slider">
        <div className="slider__arrow-left">
          <span 
            className="arrow"
            onClick={() => {
                document.getElementById(id).scrollLeft -= window.innerWidth - 80;
            }}
        >
            {"<"}
        </span>
        </div>

        <div id={id} className="row__posters">
          {/** SERVERAL ROW__POSTERS */}
          {movies.map((movie) => (
            <img
              key={movie.id}
              className={`row__posters ${isLargeRow && "row__posterLarge"}`}
              src={`https://image.tmdb.org/t/p/original/${
                isLargeRow ? movie.poster_path : movie.backdrop_path
              } `}
              loading="lazy"
              alt={movie.name}
            />
          ))}
        </div>

        <div className="slider__arrow-right">
          <span className="arrow">{">"}</span>
        </div>
      </div>
    </section>
  );
}
