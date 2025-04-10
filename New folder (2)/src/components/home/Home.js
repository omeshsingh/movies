import Hero from '../hero/Hero';

const Home = ({ movies }) => {
  return (
    <div>
      {movies && movies.length > 0 ? (
        <Hero movies={movies} />
      ) : (
        <p>Loading movies...</p>
      )}
    </div>
  );
};

export default Home;
