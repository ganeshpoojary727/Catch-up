import Card from "../ui/Card";
import Button from "../ui/Button";
import { Link } from "react-router-dom";
function EventCard({
  id,
  image,
  category,
  title,
  organizer,
  location,
  date,
  interested,
  comments,
})
 {const formattedDate = new Date(date).toLocaleDateString();
  return (
    <Card className="transition-all duration-300 hover:-translate-y-1 hover:shadow-2xl">
     <img
  src={image || "https://picsum.photos/900/500"}
  alt={title}
  className="w-full h-56 object-cover rounded-t-xl"
  onError={(e) => {
    e.target.src = "https://picsum.photos/900/500";
  }}
/>

      <div className="p-6">

        <span className="inline-flex items-center gap-1 px-4 py-1 rounded-full bg-indigo-100 text-indigo-700 font-medium text-sm">
    🎯 {category}
</span>

        <h2 className="text-3xl font-bold mt-4 leading-tight text-gray-900">
          {title}
        </h2>

       <div className="flex items-center gap-3 mt-4">
    <div className="w-10 h-10 rounded-full bg-indigo-500 flex items-center justify-center text-white font-bold">
        {organizer.charAt(0).toUpperCase()}
    </div>

    <div>
        <p className="font-semibold text-gray-800">
            {organizer}
        </p>

        <p className="text-sm text-gray-500">
            Organizer
        </p>
    </div>
</div>

        <div className="flex justify-between items-center mt-6 text-gray-500">
          <span>📍 {location}</span>
<span>📅 {formattedDate}</span>
        </div>

        <div className="flex gap-8 mt-6 text-gray-600">

    <div className="flex items-center gap-2">
        ❤️
        <span>{interested} Interested</span>
    </div>

    <div className="flex items-center gap-2">
        💬
        <span>{comments} Comments</span>
    </div>

</div>

        <div className="flex gap-4 mt-6">
          <Button>Interested</Button>

         <Link to={`/events/${id}`}>
  <Button variant="secondary">
    View Details
  </Button>
</Link>
        </div>

      </div>
    </Card>
  );
}

export default EventCard;