import API from "./api";

export const getAllEvents = async () => {
  const response = await API.get("/events");
  return response.data;
};