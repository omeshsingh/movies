import { useEffect, useRef, useState } from 'react';
import api from '../../api/axiosConfig';
import { useParams } from 'react-router-dom';
import { Container, Row, Col } from 'react-bootstrap';
import ReviewForm from '../reviewForm/ReviewForm';
import React from 'react';

const Reviews = () => {
  const revText = useRef();
  const { movieId } = useParams();

  const [movie, setMovie] = useState(null);
  const [reviews, setReviews] = useState([]);

  const getMovieData = async (id) => {
    try {
      const response = await api.get(`/api/v1/movies/${id}`);
      const singleMovie = response.data;

      setMovie(singleMovie);
      setReviews(singleMovie.reviews || []);
      console.log("Fetched movie data:", singleMovie); // 🧪 Log this

    } catch (error) {
      console.error("Error fetching movie data:", error);
    }
  };

  useEffect(() => {
    getMovieData(movieId);
  }, [movieId]);

  const addReview = async (e) => {
    e.preventDefault();
    const rev = revText.current;

    try {
      await api.post("api/v1/reviews", {
        reviewBody: rev.value,
        imdbId: movieId,
      });

      const updatedReviews = [...reviews, { body: rev.value }];
      setReviews(updatedReviews);
      rev.value = "";
    } catch (err) {
      console.error(err);
    }
  };

  return (
    <Container>
      <Row>
        <Col><h3>Reviews</h3></Col>
      </Row>

      <Row className="mt-2">
        <Col md="4">
          <img src={movie?.poster} alt="Movie Poster" style={{ width: "100%" }} />
        </Col>

        <Col md="8">
          <Row>
            <Col>
              <ReviewForm
                handleSubmit={addReview}
                revText={revText}
                labelText="Write a Review?"
              />
            </Col>
          </Row>

          <Row><Col><hr /></Col></Row>

          {
            reviews?.length > 0 ? (
              reviews.map((r, index) => (
                <React.Fragment key={index}>
                  <Row>
                    <Col>
                      <div className="review-body">{r.body}</div>
                    </Col>
                  </Row>
                  <Row><Col><hr /></Col></Row>
                </React.Fragment>
              ))
            ) : (
              <Row>
                <Col><p>No reviews yet. Be the first to leave one!</p></Col>
              </Row>
            )
          }
        </Col>
      </Row>

      <Row>
        <Col><hr /></Col>
      </Row>
    </Container>
  );
};

export default Reviews;
