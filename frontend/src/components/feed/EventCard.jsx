import Card from "../ui/Card";
import Button from "../ui/Button";

function EventCard({
  image,
  category,
  title,
  organizer,
  location,
  date,
  interested,
  comments,
}) {
  return (
    <Card>
      <img
        src={image}
        alt={title}
        className="w-full h-72 object-cover rounded-t-xl"
      />

      <div className="p-6">

        <span className="inline-block px-3 py-1 text-sm rounded-full bg-indigo-100 text-indigo-600">
          {category}
        </span>

        <h2 className="text-3xl font-bold mt-4">
          {title}
        </h2>

        <p className="text-gray-600 mt-2">
          Organized by {organizer}
        </p>

        <div className="flex justify-between mt-5 text-gray-500">
          <span>📍 {location}</span>
          <span>📅 {date}</span>
        </div>

        <div className="flex gap-6 mt-5 text-gray-600">
          <span>👥 {interested} Interested</span>
          <span>💬 {comments} Comments</span>
        </div>

        <div className="flex gap-4 mt-6">
          <Button>Interested</Button>

          <Button variant="secondary">
            View Details
          </Button>
        </div>

      </div>
    </Card>
  );
}

export default EventCard;