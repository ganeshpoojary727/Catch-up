import EventCard from "./EventCard";

function FeedSection({ title }) {
  return (
    <section className="mb-10">
      <h2 className="text-2xl font-bold text-gray-800 mb-5">
        {title}
      </h2>

      <div className="space-y-8">
        <EventCard />
        <EventCard />
        <EventCard />
      </div>
    </section>
  );
}

export default FeedSection;