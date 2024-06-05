import cv2
import pytesseract
import tkinter as tk
from tkinter import messagebox
from PIL import Image, ImageTk

# Configuration for tesseract
pytesseract.pytesseract.tesseract_cmd = r'C:\Program Files\Tesseract-OCR\tesseract.exe'  # Update this path if needed

class BallotApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Ballot Counter")

        self.label = tk.Label(root, text="Press 'Capture' to take a photo of the ballot.")
        self.label.pack()

        self.capture_button = tk.Button(root, text="Capture", command=self.capture_image)
        self.capture_button.pack()

        self.count_button = tk.Button(root, text="Count Checkboxes", command=self.count_checkboxes, state=tk.DISABLED)
        self.count_button.pack()

        self.result_label = tk.Label(root, text="")
        self.result_label.pack()

        self.image_label = tk.Label(root)
        self.image_label.pack()

        self.image_path = None

    def capture_image(self):
        cap = cv2.VideoCapture(0)
        if not cap.isOpened():
            messagebox.showerror("Error", "Could not open camera.")
            return

        while True:
            ret, frame = cap.read()
            if not ret:
                messagebox.showerror("Error", "Could not read frame.")
                break
            
            cv2.imshow('Capture Image', frame)
            if cv2.waitKey(1) & 0xFF == ord('s'):
                self.image_path = 'captured_ballot.jpg'
                cv2.imwrite(self.image_path, frame)
                break

        cap.release()
        cv2.destroyAllWindows()

        if self.image_path:
            self.display_image(self.image_path)
            self.count_button.config(state=tk.NORMAL)

    def display_image(self, path):
        img = Image.open(path)
        img = img.resize((400, 300), Image.ANTIALIAS)
        imgtk = ImageTk.PhotoImage(img)
        self.image_label.config(image=imgtk)
        self.image_label.image = imgtk

    def preprocess_image(self, image_path):
        image = cv2.imread(image_path, cv2.IMREAD_GRAYSCALE)
        _, binary_image = cv2.threshold(image, 150, 255, cv2.THRESH_BINARY_INV)
        return binary_image

    def detect_checkboxes(self, binary_image):
        contours, _ = cv2.findContours(binary_image, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
        checkboxes = []
        for contour in contours:
            epsilon = 0.02 * cv2.arcLength(contour, True)
            approx = cv2.approxPolyDP(contour, epsilon, True)
            if len(approx) == 4:
                x, y, w, h = cv2.boundingRect(contour)
                aspect_ratio = w / float(h)
                if 0.8 <= aspect_ratio <= 1.2:
                    checkboxes.append((x, y, w, h))
        return checkboxes

    def count_checked_boxes(self, image_path):
        binary_image = self.preprocess_image(image_path)
        checkboxes = self.detect_checkboxes(binary_image)
        checked_count = 0
        for (x, y, w, h) in checkboxes:
            checkbox_region = binary_image[y:y+h, x:x+w]
            non_zero_pixels = cv2.countNonZero(checkbox_region)
            if non_zero_pixels > (w * h * 0.2):
                checked_count += 1
        return checked_count, checkboxes

    def count_checkboxes(self):
        if self.image_path:
            checked_count, checkboxes = self.count_checked_boxes(self.image_path)
            self.result_label.config(text=f"Number of checked boxes: {checked_count}")

            # Optionally, draw rectangles around detected checkboxes
            image = cv2.imread(self.image_path)
            for (x, y, w, h) in checkboxes:
                cv2.rectangle(image, (x, y), (x+w, y+h), (0, 255, 0), 2)
            cv2.imwrite('output_with_boxes.jpg', image)
            self.display_image('output_with_boxes.jpg')
        else:
            messagebox.showerror("Error", "No image captured.")

if __name__ == "__main__":
    root = tk.Tk()
    app = BallotApp(root)
    root.mainloop()
