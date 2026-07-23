import { useState } from "react";
import Comment from "./Comment";

function CommentSection() {

  const [comments, setComments] = useState([
    {
      id: 1,
      username: "Ganesh",
      text: "Amazing event! Looking forward to it.",
      time: "2h ago",
    },
    {
      id: 2,
      username: "Rahul",
      text: "I'm bringing my friends too.",
      time: "30m ago",
    },
  ]);

  const [newComment, setNewComment] = useState("");

  const addComment = () => {

    if (newComment.trim() === "") return;

    const comment = {
      id: Date.now(),
      username: "You",
      text: newComment,
      time: "Just now",
    };

    setComments([comment, ...comments]);
    setNewComment("");

  };

  return (
    <div className="mt-14">

      <h2 className="text-3xl font-bold mb-8">
        💬 Comments
      </h2>

      <div className="space-y-2">

        {comments.map((comment) => (
          <Comment
            key={comment.id}
            comment={comment}
          />
        ))}

      </div>

      <div className="mt-8">

        <textarea
          rows="4"
          placeholder="Write your comment..."
          value={newComment}
          onChange={(e) => setNewComment(e.target.value)}
          className="w-full border rounded-xl p-4 outline-none focus:ring-2 focus:ring-indigo-500"
        />

        <button
          onClick={addComment}
          className="mt-4 bg-indigo-600 text-white px-8 py-3 rounded-xl hover:bg-indigo-700"
        >
          Post Comment
        </button>

      </div>

    </div>
  );
}

export default CommentSection;