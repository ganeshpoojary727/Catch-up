import API from "./api";

export const getAllEvents = async () => {
  const response = await API.get("/events");
  return response.data;
};

export const getEventById = async (id) => {
  const response = await API.get(`/events/${id}`);
  return response.data;
};
export const markInterested = async (id) => {

    const response = await API.post(`/events/${id}/interested`);

    return response.data;

};
export const removeInterested = async (id) => {

    const response = await API.delete(`/events/${id}/interested`);

    return response.data;

};