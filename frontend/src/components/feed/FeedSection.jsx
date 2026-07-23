import EventCard from "./EventCard";
import EventSkeleton from "./EventSkeleton";
function FeedSection({
    title,
    events = [],
    loading,
    error,
}) {
   if (loading) {
  return (
    <section className="mb-10">

      <h2 className="text-2xl font-bold mb-5">
        {title}
      </h2>

      <div className="space-y-8">
        <EventSkeleton />
        <EventSkeleton />
        <EventSkeleton />
      </div>

    </section>
  );
}
if (error) {
    return (
        <section className="mb-10">
            <h2 className="text-2xl font-bold mb-5">{title}</h2>
            <p className="text-red-500">{error}</p>
        </section>
    );
}
  return (
    <section className="mb-10">

      <h2 className="text-2xl font-bold mb-5">
        {title}
      </h2>

      <div className="space-y-8">
        

        {events.map((event) => (
         <EventCard
  key={event.id}
  id={event.id}
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