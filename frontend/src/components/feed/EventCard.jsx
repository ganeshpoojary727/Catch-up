import Card from "../ui/Card";
import Button from "../ui/Button";

function EventCard() {
  return (
    <Card className="max-w-xl mx-auto">

      <img
        src="https://images.unsplash.com/photo-1511578314322-379afb476865?w=1200"
        alt="Event"
        className="w-full h-60 object-cover"
      />

      <div className="p-5">

        <span className="bg-indigo-100 text-indigo-700 px-3 py-1 rounded-full text-sm">
          Technology
        </span>

        <h2 className="text-2xl font-bold mt-4">
          AI Hackathon 2026
        </h2>

        <p className="text-gray-600 mt-2">
          Organized by SDMIT Coding Club
        </p>

        <div className="flex gap-4 mt-4 text-sm text-gray-500">
          <span>📍 Ujire</span>
          <span>🗓 Tomorrow</span>
        </div>

        <div className="flex gap-5 mt-4">

          <span>❤️ 432</span>

          <span>💬 58</span>

          <span>👀 1.2K</span>

        </div>

        <div className="mt-6 flex gap-3">

          <Button>
            Interested
          </Button>

          <Button variant="secondary">
            View Details
          </Button>

        </div>

      </div>

    </Card>
  );
}

export default EventCard;