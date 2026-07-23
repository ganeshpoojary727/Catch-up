import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import {
    getEventById,
    markInterested,
    removeInterested,
} from "../services/eventService";
import CommentSection from "../components/comments/CommentSection";
function EventDetails() {


    const { id } = useParams();

    const [event, setEvent] = useState(null);

    const [isInterested, setIsInterested] = useState(false);

    useEffect(() => {

        const loadEvent = async () => {

            try {

                const data = await getEventById(id);
                setEvent(data);

            } catch (error) {
                console.error(error);
            }

        };

        loadEvent();

    }, [id]);

    if (!event) {
        return <h2>Loading...</h2>;
    }
const handleInterested = async () => {

    try {

        if (isInterested) {

            await removeInterested(id);

        } else {

            await markInterested(id);

        }

        const updatedEvent = await getEventById(id);

        setEvent(updatedEvent);

        setIsInterested(!isInterested);

    } catch (error) {

        console.error(error);

    }

};
   return (
  <div className="max-w-5xl mx-auto py-8 px-6">

    <img
     src={
  event.imageUrl &&
  event.imageUrl.startsWith("http") &&
  !event.imageUrl.includes("image.com")
    ? event.imageUrl
    : "https://picsum.photos/1200/600?random=10"
}
      alt={event.title}
      className="w-full h-96 object-cover rounded-2xl shadow-lg"
    />

    <div className="mt-8">

      <span className="px-4 py-2 rounded-full bg-indigo-100 text-indigo-600">
        {event.category}
      </span>

      <h1 className="text-5xl font-bold mt-5">
        {event.title}
      </h1>

      <div className="mt-10">

  <h2 className="text-2xl font-bold mb-4">
    About Event
  </h2>

  <p className="text-gray-700 leading-8">
    {event.description}
  </p>

</div>
      <div className="grid grid-cols-2 gap-6 mt-8">

        <div className="flex items-center gap-4">

  <div className="w-14 h-14 rounded-full bg-indigo-600 text-white flex items-center justify-center font-bold text-xl">

    {(event.createdBy?.username || "U")
      .charAt(0)
      .toUpperCase()}

  </div>

  <div>

    <p className="font-semibold text-lg">
      {event.createdBy?.username || "Unknown"}
    </p>

    <p className="text-gray-500">
      Organizer
    </p>

  </div>

</div>

        <div>
          <p className="text-gray-500">Location</p>
          <p className="font-semibold">
            {event.location}
          </p>
        </div>

        <div>
          <p className="text-gray-500">Date</p>
          <p className="font-semibold">
            {new Date(event.eventDate).toLocaleDateString()}
          </p>
        </div>

              </div>

      <div className="flex gap-4 mt-10">

      <button
    onClick={handleInterested}
    className={`px-8 py-3 rounded-xl font-semibold transition-all duration-300 ${
        isInterested
            ? "bg-red-500 text-white scale-105"
            : "bg-gray-200 text-gray-700 hover:bg-gray-300"
    }`}
>
    ❤️ Interested ({event.interestedCount})
</button>
        <button className="border border-gray-300 px-6 py-3 rounded-xl hover:bg-gray-100 transition">
          📤 Share
        </button>

      </div>

    </div>
<CommentSection />
  </div>
  
);
}
export default EventDetails;