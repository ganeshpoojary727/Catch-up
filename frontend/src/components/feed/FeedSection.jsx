import EventCard from "./EventCard";

function FeedSection({ title, events = [] }) {
  console.log(events);
  return (
    <section className="mb-10">

      <h2 className="text-2xl font-bold mb-5">
        {title}
      </h2>

      <div className="space-y-8">

        {events.map((event) => (
          <EventCard
            key={event.id}
            image={event.imageUrl}
            category={event.category}
            title={event.title}
            organizer={event.createdBy?.username || "Unknown"}
            location={event.location}
            date={event.eventDate}
            interested={event.interestedCount}
            comments={event.commentCount}
          />
        ))}

      </div>

    </section>
  );
}

export default FeedSection;